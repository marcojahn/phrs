Ext.define('PHRS.common.data.writer.Json', {
    extend: 'Ext.data.writer.Json',
    alias: 'writer.json2',

    getRecordData: function(record, operation) {
        if (record.writeStructuredData) {
            return record.getWriteData();
        } else {
            return this.callParent(arguments);
        }
    }
});