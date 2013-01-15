Ext.define('PHRS.view.Viewport', {
	extend: 'Ext.container.Viewport',
	
	requires: [
	    'Ext.layout.container.Border'
	],
	
	layout: 'border',
	
	initComponent: function () {
		this.items = [
	        {
				region : 'west',
				collapsible : true,
				title : 'Navigation',
				width : 150
				// could use a TreePanel or AccordionLayout for navigational items
			}, {
				region : 'south',
				title : 'South Panel',
				collapsible : true,
				html : 'Information goes here',
				split : true,
				height : 100,
				minHeight : 100
			}, {
				region : 'east',
				title : 'East Panel',
				collapsible : true,
				split : true,
				width : 150
			}, {
				region : 'center',
				xtype : 'tabpanel', // TabPanel itself has no title
				activeTab : 0, // First tab active by default
			    html: 'test'
				}
			}
		];
		
		this.callParent(arguments);
	}
});