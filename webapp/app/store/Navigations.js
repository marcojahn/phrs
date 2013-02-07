Ext.define('PHRS.store.Navigations', {
    extend: 'Ext.data.TreeStore',
    	
    model: 'PHRS.model.Navigation',
    
    storeId: 'Navigations',
    
    proxy: {
        type: 'memory'
    },

    autoLoad: true,
    
	root: {
		
		text: "Root",
		
		expanded: true,

		children: [{
			name: 'Dashboard',
			leaf: true,
            menuId: 'dashboard'
		},{
	        name:'Hotelverwaltung',
	        expanded: false,

	        children: [{
	            name: 'Neues Hotel',
	            icon: './img/hotel.png',
	            leaf: true,
                menuId: 'createHotel'
	        },
	        {
	        	name: 'Hotelverzeichnis',
	        	leaf: true,
                menuId: 'listHotels'
	        }]
	    }, {
	        name:'Benutzerverwaltung',
	        expanded: false,

	        children: [{
	            name: 'Neuer Benutzer',
	            leaf: true,
                menuId: 'createUser'
	        },
	        {
	        	name: 'Benutzerverzeichnis',
	        	leaf: true,
                menuId: 'listUsers'
	        }]
	    }]
	}
    
});