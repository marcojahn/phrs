Ext.define('PHRS.view.Viewport', {
	extend: 'Ext.container.Viewport',
	
	requires: [
	    'Ext.layout.container.Border',
        'PHRS.view.navigation.GridTree',
        'PHRS.view.hotel.GridList'
	],
	
	layout: 'border',
	
	initComponent: function () {
        console.log('building viewport');
		this.items = [
	        {
				region : 'west',
				collapsible : true,
				title : 'Navigation',
				width : 150,
				
				// could use a TreePanel or AccordionLayout for navigational items
				xtype : 'navigation-gridtree'
					
			}, {
				region : 'south',
				title : 'South Panel',
				collapsible : true,
				html : 'Information goes here',
				split : true,
				height : 100,
				minHeight : 100
			}, {
				region : 'center',
				xtype : 'tabpanel', // TabPanel itself has no title
				activeTab : 0, // First tab active by default
			    items: [
                    {
                        xtype: 'hotel-gridlist'
                    }
                ]
			}
		];
		
		this.callParent(arguments);
	}
});