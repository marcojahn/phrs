Ext.define('PHRS.view.navigation.GridTree', {
    extend: 'Ext.tree.Panel',

    requires: [
        'PHRS.store.Navigations'
    ],
    
    alias: 'widget.navigation-gridtree',

    title: 'Navigation',
    store: 'Navigations',
    
    collapsible: false,
    useArrows: true,
    rootVisible: false,
    singleExpand: false,
    	
    columns: [{
        xtype: 'treecolumn', 
        text: 'Entry',
        flex: 2,
        sortable: false,
        dataIndex: 'name'
    }],

    listeners: {
        itemclick: function (me, record, item) {
            console.log('selected record: ' + record.get('menuId'));
            // TODO tabchange/create
        }
    }
    
});