Ext.define('PHRS.view.hotel.GridList', {
    extend: 'Ext.grid.GridPanel',

    requires: [
        'PHRS.store.Hotels'
    ],

    alias: 'widget.hotel-gridlist',

    title: 'Hotelliste',
    store: 'Hotels',
    columns: [
        { text: 'id',  dataIndex: 'id', editor: undefined },
        { text: 'Hotel', dataIndex: 'name', flex: 1, editor: 'textfield' }
    ],

    selType: 'rowmodel',
    plugins: [
        Ext.create('Ext.grid.plugin.RowEditing', {
            clicksToEdit: 1
        })
    ]
});