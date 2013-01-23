Ext.define('PHRS.model.User', {
    extend: 'PHRS.model.PhrsEntity',

    fields: [
        {name: 'userName'},
        {name: 'password'},
        {name: 'role'},
        {name: 'email'},
        {name: 'firstName'},
        {name: 'lastName'},
        {name: 'project'},
        {name: 'key', type: 'string', persist: false}
    ]

    // todo reservation as association
});