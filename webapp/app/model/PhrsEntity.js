Ext.define('PHRS.model.PhrsEntity', {
    extend: 'Ext.data.Model',

    fields: [
        {name: 'id', type: 'int'},
        {name: 'version', type: 'int'},
        {name: 'created', type: 'date'},
        {name: 'createdBy'},
        {name: 'modified', type: 'date'},
        {name: 'modifiedBy'}
    ]
});