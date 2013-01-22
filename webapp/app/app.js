(function () {
    Ext.Ajax.defaultHeaders = {
        'Content-Type': 'application/json; charset=UTF-8'
    };

    Ext.application({
        name: 'PHRS',
        autoCreateViewport: false,
        requires: ['PHRS.view.Viewport'],

        //controllers: ['PHRS.controller.XY'],

        launch: function () {

            var loginForm;
            loginForm = Ext.create('Ext.window.Window', {
                title: 'Login',
                height: 150,
                width: 300,
                layout: 'fit',
                items: [{
                    xtype: 'form',
                    header: false,
                    layout: 'anchor',
                    defaults: {
                        anchor: '100%',
                        labelWidth: 100/*,
                        listeners: {
                            specialkey: function (field, event) {
                                if (event.getKey() == event.ENTER) {
                                    field.up('form').getForm().submit();
                                }
                            }
                        }*/
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
                    buttons: [{
                        text: 'Login',
                        formBind: true,
                        disabled: true,
                        handler: function () {
                            var submitJson = null,
                                form = this.up('form').getForm(),
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
                                    url: '/phrs/rest/user/login/v1',
                                    params: submitJson,
                                    success: function (response) {
                                        Ext.Msg.alert('Success', response.responseText);
                                        loginForm.close(),
                                        Ext.create('PHRS.view.Viewport');
                                    },
                                    failure: function () {
                                        console.log('fail')
                                        passwordField.enable();
                                        userNameField.enable();
                                    }
                                });

                                /*form.submit({
                                    params: {
                                        userName:userNameField.getValue(),
                                        password:CryptoJS.SHA3(passwordField.getValue()).toString()
                                    },
                                    success: function (form, action) {
                                        Ext.Msg.alert('Success', action.result.msg);
                                        Ext.create('PHRS.view.Viewport');
                                    },
                                    failure: function (form, action) {
                                        switch (action.failureType) {
                                            case Ext.form.action.Action.CLIENT_INVALID:
                                                //Ext.Msg.alert('Failure', 'Form fields may not be submitted with invalid values');
                                                labelField.setValue('Form field my not be submitted with invalid values.');
                                                break;
                                            case Ext.form.action.Action.CONNECT_FAILURE:
                                                //Ext.Msg.alert('Failure', 'Ajax communication failed');
                                                labelField.setValue('Ajax communication failed.');
                                                break;
                                            case Ext.form.action.Action.SERVER_INVALID:
                                                //Ext.Msg.alert('Failure', action.result.msg);
                                                labelField.setValue(action.result.msg);
                                        }
                                        passwordField.enable();
                                        userNameField.enable();
                                    }
                                })*/

                                passwordField.disable();
                                userNameField.disable();
                            }
                        }
                    }]
                }]
            }).show();

        }
    });
})();