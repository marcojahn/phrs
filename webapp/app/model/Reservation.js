Ext.define('PHRS.model.Reservation', {
    extend: 'PHRS.model.PhrsEntity',

    fields: [
        {name: 'date', type: 'date'},
        {name: 'hotelChanged', type: 'boolean'},
        {name: 'comment'},
        {name: 'status'} // reservation status
    ],

    associations: [
        {
            type: 'hasOne',
            model: 'PHRS.model.Hotel',
            name: 'hotel',
            associationKey: 'hotel',
            autoLoad: true,
            foreignKey: 'id',
            getterName: 'getHotel',
            setterName: 'setHotel'
        }
    ]
});