Ext.define('PHRS.view.reservation.ReservationForm', {
    extend: 'Ext.form.Panel',

    id: 'reservation-reservationform',

    requires: [
        'PHRS.model.Reservation',
        'PHRS.store.Hotels'
    ],

    alias: 'widget.reservation-reservationform',

    title: 'Neue Reservierung',

    bodyPadding: 20,
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

        return [
            {
                name: 'date',
                fieldLabel: 'Datum',
                xtype: 'datefield',
                allowBlank: false,
                msgTarget: 'side'
            },
            {
                xtype: 'combobox',
                name: 'hotel',
                fieldLabel: 'Hotel',
                allowBlank: false,
                msgTarget: 'side',
                store: 'Hotels',
                queryMode: 'local',
                displayField: 'name',
                valueVield: 'name'
            },
            {
                name: 'comment',
                fieldLabel: 'Kommentar',
                xtype: 'textarea',
                allowBlank: true,
                msgTarget: 'side'
            }
        ]
    },

    buildButtons: function () {
        return [
            {
                text: 'Anfragen',
                formBind: true,
                disabled: true,
                action: 'saveReservation'

            }
        ];

    }

})
;