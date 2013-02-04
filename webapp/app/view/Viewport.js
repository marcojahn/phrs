Ext.define('PHRS.view.Viewport', {
	extend: 'Ext.container.Viewport',
	
	requires: [
	    'Ext.layout.container.Border',
        'PHRS.view.navigation.GridTree',
        'PHRS.view.hotel.GridList',
        'PHRS.view.hotel.HotelForm',
        'PHRS.view.main.ReservationChart',
        'PHRS.view.main.Dashboard'
	],
	
	layout: 'border',
	
	initComponent: function () {
        console.log('building viewport');
		this.items = [
	        {
				region : 'west',
				collapsible : true,
				title : 'Navigation',
				width : 250,
				
				// could use a TreePanel or AccordionLayout for navigational items
				xtype : 'navigation-gridtree'
					
			}, {
				region : 'south',
				title : '&copy; 2013, Marco Jahn & Nicolas Moser',
				split : false
			}, {
				region : 'center',
				xtype : 'tabpanel', // TabPanel itself has no title
				activeTab : 0, // First tab active by default
			    
				items: [
					{
					    xtype: 'main-dashboard'
					},
                    {
                        xtype: 'hotel-gridlist'
                    },
                    {
                        xtype: 'container',
                        title: 'neues Hotel',
                        items: [{xtype: 'hotel-hotelform'}]
                    }
                ],
                
                defaults: {
                	closable: true
                }
			}
		];
		
		this.callParent(arguments);
	}
});