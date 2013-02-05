Ext.define('PHRS.model.ChartReservation', {
    extend: 'Ext.data.Model',

    fields: [
        {name: 'year', type: 'int'},
        {name: 'comedy', type: 'int'},
        {name: 'action', type: 'int'},
        {name: 'drama', type: 'int'},
        {name: 'thriller', type: 'int'},
        {name: 'comic', type: 'int'},
        {name: 'anime', type: 'int'},
        {name: 'manga', type: 'int'}
    ]
});