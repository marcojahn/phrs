Ext.define('PHRS.model.PhrsEntity', {
    extend: 'Ext.data.Model',

    fields: [
        {name: 'id', type: 'int', defaultValue: null, useNull: true},
        {name: 'version', type: 'int', defaultValue: null, useNull: true},
        {name: 'created', type: 'date', defaultValue: null, useNull: true},
        {name: 'createdBy', defaultValue: null, useNull: true},
        {name: 'modified', type: 'date', defaultValue: null, useNull: true},
        {name: 'modifiedBy', defaultValue: null, useNull: true}
    ],

    writeStructuredData: true,

    getWriteData: function () {
        var data = this.getRecordWriteData(this),
            associations = this.associations.items,
            association, type, name, associatedStore,
            associatedRecords, associatedRecord,
            a, aLen, r, rLen;

        for (a = 0, aLen = associations.length; a < aLen; a++) {

            association = associations[a];
            type = association.type;
            name = association.name;

            if (type == 'hasMany') {

                associatedStore = this[association.storeName];
                // Initialize the array for this association
                data[name] = [];

                // If the association's loaded, process its records
                if (associatedStore && associatedStore.getCount() > 0) {
                    associatedRecords = associatedStore.data.items;

                    // Append data for each record
                    for (r = 0, rLen = associatedRecords.length; r < rLen; r++) {
                        data[name][r] = this.getRecordWriteData(associatedRecords[r]);
                    }
                }

            } else if (type == 'hasOne') {
                associatedRecord = this[association.instanceName];
                // If the record exists, append its data
                if (associatedRecord !== undefined) {
                    data[name] = this.getRecordWriteData(associatedRecord);
                }
            }

        }

        return data;
    },

    getRecordWriteData: function (record) {
        var isPhantom = record.phantom === true,
            writeAllFields = record.writeAllFields,
            fields = record.fields,
            fieldItems = fields.items,
            data = {},
            changes = record.getChanges(),
            field,
            key,
            f, fLen;

        for (f = 0, fLen = fieldItems.length; f < fLen; f++) {
            field = fieldItems[f];

            if (field.forcePersist || (field.persist && (writeAllFields || isPhantom))) {
                this.setFieldWriteData(data, record, field, record.get(field.name));
            }
        }

        for (key in changes) {
            if (changes.hasOwnProperty(key)) {
                field = fields.get(key);
                if (field.persist) {
                    this.setFieldWriteData(data, record, field, changes[key]);
                }
            }
        }

        return data;
    },

    setFieldWriteData: function (data, record, field, value) {
        var name = field[this.nameProperty] || field.name,
            path, i, len, curr;

        if (field.name === record.idProperty && record.phantom) {
            return;
        }

        if (field.mapping) {
            if (field.mapping.indexOf('.')) {
                path = field.mapping.split('.');
                curr = data;
                for (i = 0, len = path.length - 1; i < len; i++) {
                    if (!curr[path[i]]) {
                        curr[path[i]] = {};
                    }
                    curr = curr[path[i]];
                }
                curr[path[i]] = value;
            }
        } else {
            data[name] = value;
        }
    }
});