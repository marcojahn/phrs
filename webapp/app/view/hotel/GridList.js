Ext.define('PHRS.view.hotel.GridList', {
    extend: 'Ext.grid.GridPanel',

    requires: [
        'PHRS.store.Hotels'
    ],

    alias: 'widget.hotel-gridlist',

    title: 'Hotelliste',
    store: 'Hotels',

    columns: [
        { text: 'ID', dataIndex: 'id', editor: undefined },
        { text: 'Name', dataIndex: 'name', flex: 1, editor: 'textfield' },
        { text: 'Straße', dataIndex: 'street', flex: 1, editor: 'textfield' },
        { text: 'Hausnummer', dataIndex: 'streetNumber', editor: 'textfield' },
        { text: 'Stadt', dataIndex: 'city', editor: 'textfield' },
        { text: 'PLZ', dataIndex: 'zipCode', editor: 'textfield' },
        { text: 'Telefon', dataIndex: 'phoneNumber', editor: 'textfield' },
        { text: 'Fax', dataIndex: 'faxNumber', editor: 'textfield' },
        { text: 'E-Mail', dataIndex: 'email', flex: 1, editor: 'textfield', renderer: function (value) {
            if (value) {
                return Ext.String.format('<a href="mailto:{0}">{1}</a>', value, value);
            }
        }},
        {
            xtype: 'actioncolumn',
            width: 50,
            items: [
                {
                    icon: './img/icons/delete.png',
                    tooltip: 'Löschen',
                    handler: function (grid, rowIndex, colIndex) {
                        /*var rec = grid.getStore().getAt(rowIndex);
                        grid.getStore().remove(rec);*/
                        grid.getStore().removeAt(rowIndex);
                    }
                }
            ]
        }
    ],

    selType: 'rowmodel',
    plugins: [
        Ext.create('Ext.grid.plugin.RowEditing', {
            clicksToEdit: 2
        })
    ]
});