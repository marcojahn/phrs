Ext.define('PHRS.view.navigation.GridTree', {
    extend: 'Ext.tree.Panel',

    requires: [
        'PHRS.store.Navigations'
    ],
    
    alias: 'widget.navigation-gridtree',

    title: 'Navigation',
    store: 'Navigations',
    
    collapsible: true,
    useArrows: false,
    rootVisible: false,
    singleExpand: true,
    	
    columns: [{
        xtype: 'treecolumn', 
        text: 'Entry',
        flex: 2,
        sortable: false,
        dataIndex: 'name'
    }]
    
});