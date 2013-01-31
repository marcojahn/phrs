Ext.define('PHRS.view.hotel.GridList', {
    extend: 'Ext.grid.GridPanel',

    requires: [
        'PHRS.store.Hotels'
    ],

    alias: 'widget.hotel-gridlist',

    title: 'Hotelliste',
    store: 'Hotels',
    columns: [
        { text: 'ID',  dataIndex: 'id', editor: undefined },
        { text: 'Name', dataIndex: 'name', flex: 1, editor: 'textfield' },
        { text: 'Straﬂe', dataIndex: 'street', flex: 1, editor: 'textfield' },
        { text: 'Hausnummer', dataIndex: 'streetNumber', editor: 'textfield' },
        { text: 'Stadt', dataIndex: 'city', editor: 'textfield' },
        { text: 'PLZ', dataIndex: 'zipCode', editor: 'textfield' },
        { text: 'Telefon', dataIndex: 'phoneNumber', editor: 'textfield' },
        { text: 'Fax', dataIndex: 'faxNumber', editor: 'textfield' },
        { text: 'E-Mail', dataIndex: 'email', flex: 1, editor: 'textfield', renderer: function (value) {
        	if (value) {
        		return Ext.String.format('<a href="mailto:{0}">{1}</a>', value, value);
        	}
        }}
    ],
    
    selType: 'rowmodel',
    plugins: [
        Ext.create('Ext.grid.plugin.RowEditing', {
            clicksToEdit: 2
        })
    ]
});