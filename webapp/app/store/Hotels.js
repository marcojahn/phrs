Ext.define('PHRS.store.Hotels', {
    extend: 'Ext.data.Store',

    model: 'PHRS.model.Hotel',

    storeId: 'Hotels',

    proxy: {
        type: 'ajax',
        url: 'http://localhost:8080/phrs/rest/hotel/v1',
        actionMethods: {
            create : 'POST',
            read   : 'GET',
            update : 'PUT',
            destroy: 'DELETE'
        }
    },

    autoSync: true
});