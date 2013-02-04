Ext.define('PHRS.view.hotel.HotelForm', {
    extend: 'Ext.form.Panel',

    id: 'hotel-hotelform',

    requires: [
        'PHRS.model.Hotel'
    ],

    alias: 'widget.hotel-hotelform',

    title: 'Neues Hotel',

    margin: 10,
    bodyPadding: 10,
    width: 550,
    autoHeight: true,

    defaults: {
        anchor: '100%',
        labelWidth: 150
    },

    initComponent: function () {

        this.items = this.buildItems();

        this.buttons = this.buildButtons();

        this.callParent(arguments);
    },

    buildItems: function () {
        var countries = Ext.create('Ext.data.Store', { // todo refactor
            fields: ['abbr', 'name'],
            data : [
                {'abbr':'DE', 'name':'Deutschland'},
                {'abbr':'AT', 'name':'Österreich'},
                {'abbr':'CH', 'name':'Schweiz'}
            ]
        });

        // TODO refactor several levels of defaults !
        // TODO refactor msgTarget to app wide setting
        return [
            {
                name: 'name',
                fieldLabel: 'Hotelname',
                xtype: 'textfield',
                allowBlank: false,
                msgTarget: 'side'
            },
            {
                xtype: 'fieldcontainer',
                fieldLabel: 'Adresse',
                combineErrors: true,
                msgTarget: 'side',
                layout: 'hbox',
                defaults: {
                    flex: 1,
                    hideLabel: true
                },
                items: [
                    {
                        name: 'street',
                        fieldLabel: 'Straße',
                        margin: '0 5 0 0',
                        xtype: 'textfield',
                        allowBlank: false,
                        msgTarget: 'side',
                        flex: 10
                    },
                    {
                        name: 'streetNumber',
                        fieldLabel: 'Hausnummer',
                        xtype: 'textfield',
                        allowBlank: false,
                        msgTarget: 'side'
                    }
                ]
            },
            {
                name: 'city',
                fieldLabel: 'Stadt',
                xtype: 'textfield',
                allowBlank: false,
                msgTarget: 'side'
            },
            {
                name: 'zipCode',
                fieldLabel: 'PLZ',
                xtype: 'textfield',
                allowBlank: false,
                msgTarget: 'side'
            },
            {
                xtype: 'combobox',
                name: 'country',
                fieldLabel: 'Land',
                allowBlank: false,
                msgTarget: 'side',
                store: countries,
                queryMode: 'local',
                displayField: 'name',
                valueVield: 'name'
            },
            {
                name: 'phoneNumber',
                fieldLabel: 'Telefon',
                xtype: 'textfield',
                allowBlank: false,
                msgTarget: 'side'
            },
            {
                name: 'faxNumber',
                fieldLabel: 'Fax',
                xtype: 'textfield',
                allowBlank: false,
                msgTarget: 'side'
            },
            {
                name: 'email',
                fieldLabel: 'EMail',
                xtype: 'textfield',
                allowBlank: false,
                msgTarget: 'side',
                vtype: 'email'
            }
        ]
    },

    buildButtons: function () {
        return [
            {
                text: 'Speichern',
                formBind: true,
                disabled: true,
                action: 'saveHotel'

            },
            {
                text: 'Abbrechen',
                action: 'resetHotel'
            }
        ];

    }

})
;