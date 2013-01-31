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
			leaf: true
		},{
	        name:'Hotelverwaltung',
	        expanded: false,

	        children: [{
	            name: 'Neues Hotel',
	            icon: './img/hotel.png',
	            leaf: true
	        },
	        {
	        	name: 'Hotelverzeichnis',
	        	leaf: true
	        }]
	    }, {
	        name:'Benutzerverwaltung',
	        expanded: false,

	        children: [{
	            name: 'Neuer Benutzer',
	            leaf: true
	        },
	        {
	        	name: 'Benutzerverzeichnis',
	        	leaf: true
	        }]
	    }]
	}
    
});