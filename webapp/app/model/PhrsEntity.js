Ext.define('PHRS.model.PhrsEntity', {
    extend: 'Ext.data.Model',

    fields: [
        {name: 'id', type: 'int', defaultValue: null},
        {name: 'version', type: 'int', defaultValue: null},
        {name: 'created', type: 'date'},
        {name: 'createdBy'},
        {name: 'modified', type: 'date'},
        {name: 'modifiedBy'}
    ]
});