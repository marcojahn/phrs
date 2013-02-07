Ext.define('PHRS.model.Reservation', {
    extend: 'PHRS.model.PhrsEntity',

    fields: [
        {name: 'date', type: 'date'},
        {name: 'hotelChanged', type: 'boolean'},
        {name: 'comment', type: 'string', useNull: true},
        {name: 'status', type: 'string', defaultValue: null, useNull: true} // reservation status
    ],

    associations: [
        {
            type: 'hasOne',
            model: 'PHRS.model.Hotel',
            name: 'hotel',
            associationKey: 'hotel',
            autoLoad: false,
            foreignKey: 'id',
            getterName: 'getHotel',
            setterName: 'setHotel'
        }
    ]
});