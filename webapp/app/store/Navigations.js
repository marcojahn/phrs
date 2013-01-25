Ext.define('PHRS.store.Navigations', {
    extend: 'Ext.data.TreeStore',
    	
    model: 'PHRS.model.Navigation',
    
    storeId: 'Navigations',
    
    proxy: {
        type: 'memory'
    },

    autoLoad: true;
    
	root: {
		
		text: "Root",
		
		expanded: true,

		children: [{
	        name:'Hotelverwaltung',
	        expanded: true,

	        children: [{
	            name: 'Neues Hotel',
	            leaf: true
	        },
	        {
	        	name: 'Hotelverzeichnis',
	        	leaf: true
	        }]
	    },{
	        name:'Benutzerverwaltung',
	        expanded: true,

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