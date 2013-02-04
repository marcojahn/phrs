(function () {
    Ext.Ajax.defaultHeaders = {
        'Content-Type': 'application/json; charset=UTF-8'
    };

    Ext.ns('PHRS.application');

    Ext.application({
        name: 'PHRS',
        autoCreateViewport: false,
        requires: ['PHRS.view.Viewport'],

        controllers: ['PHRS.controller.Hotel'],

        onBeforeLaunch: function () {

            Ext.apply(PHRS, {application: this});
            var me = this; // todo refactor

            var loginForm;
            loginForm = Ext.create('Ext.window.Window', {
                title: 'Login',
                height: 160,
                width: 300,
                layout: 'fit',
                items: [{
                    xtype: 'form',
                    header: false,
                    layout: 'anchor',
                    defaults: {
                        anchor: '100%',
                        labelWidth: 100,
                        listeners: {
                            specialkey: function (field, event) {
                                if (event.getKey() == event.ENTER) {
                                    loginForm.items.getAt(0).submit(); // rewrite to this.* accessor after MVC move
                                }
                            }
                        }
                    },
                    bodyPadding: '20 10',
                    defaultType: 'textfield',
                    url: 'http://localhost:8080/phrs/rest/user/login/v1',
                    jsonSubmit: true,
                    items: [
                        {
                            fieldLabel: 'Username:',
                            name: 'tmp_userName',
                            allowBlank: false
                        },
                        {
                            fieldLabel: 'Password:',
                            name: 'tmp_password',
                            allowBlank: false,
                            inputType: 'password'
                        },
                        {
                            xtype: 'displayfield',
                            name: 'errorfield'
                        }
                    ],
                    submit: function () {
                        var submitJson = null,
                            form = loginForm.items.getAt(0).getForm(),
                            userNameField = form.findField('tmp_userName'),
                            passwordField = form.findField('tmp_password'),
                            labelField = form.findField('errorfield'); // todo rewrite if moved to MVC structure

                        if (form.isValid()) {
                            // try/catch

                            submitJson = Ext.String.format('{0}', Ext.encode({
                                userName:userNameField.getValue(),
                                password:CryptoJS.SHA3(passwordField.getValue()).toString()
                            }));

                            Ext.Ajax.request({
                                url: 'http://localhost:8080/phrs/rest/user/login/v1',
                                params: submitJson,
                                success: function (response) {
                                    Ext.Msg.alert('Success', response.responseText);

                                    PHRS.application.SessionUser = Ext.create('PHRS.model.User', Ext.decode(response.responseText));

                                    Ext.Ajax.defaultHeaders = Ext.apply(Ext.Ajax.defaultHeaders, {
                                        'X-SecurityToken': PHRS.application.SessionUser.get('key')
                                    });

                                    loginForm.close();
                                    //me.onBeforeLaunch.call(me);
                                    //me.callParent();
                                    Ext.app.Application.prototype.onBeforeLaunch.call(me);
                                },
                                failure: function () {
                                    labelField.setValue('MUHAHAHA... FAIL!');
                                    passwordField.enable();
                                    userNameField.enable();
                                }
                            });

                            passwordField.disable();
                            userNameField.disable();
                        }
                    },
                    buttons: [{
                        text: 'Login',
                        formBind: true,
                        disabled: true,
                        handler: function () {
                            loginForm.items.getAt(0).submit(); // rewrite to this.* accessor after MVC move
                        }
                    }]
                }]
            }).show();

        },

        launch: function () {
            Ext.create('PHRS.view.Viewport');
        }
    });
})();