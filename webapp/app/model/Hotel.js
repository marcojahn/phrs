Ext.define('PHRS.model.Hotel', {
    extend: 'PHRS.model.PhrsEntity',

    fields: [
        {name: 'id', type: 'int'}, // ???
        {name: 'name'},
        {name: 'street'},
        {name: 'streetNumber'},
        {name: 'city'},
        {name: 'zipCode'},
        {name: 'country'},
        {name: 'phoneNumber'},
        {name: 'faxNumber'},
        {name: 'email'}
    ]
});