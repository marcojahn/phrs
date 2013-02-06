Ext.define('PHRS.model.PhrsEntity', {
    extend: 'Ext.data.Model',

    fields: [
        {name: 'id', type: 'int', defaultValue: null, useNull: true},
        {name: 'version', type: 'int', defaultValue: null, useNull: true},
        {name: 'created', type: 'date', defaultValue: null, useNull: true},
        {name: 'createdBy', defaultValue: null, useNull: true},
        {name: 'modified', type: 'date', defaultValue: null, useNull: true},
        {name: 'modifiedBy', defaultValue: null, useNull: true}
    ]
});