Ext.define('PHRS.view.main.Dashboard', {
    extend: 'Ext.panel.Panel',

    id: 'main-dashboard',

    requires: [
       'PHRS.view.reservation.ReservationForm',
       'PHRS.view.reservation.ChartPanel'
   ],
    
    alias: 'widget.main-dashboard',
    
    title: 'Dashboard',

    layout: {
        type: 'hbox',
        align: 'stretch',
        padding: 10
    },
    
    defaults: {
        flex: 1
    },
    
    items: [{
        xtype: 'container',
        margins: '0 5 0 0',
        
        layout: {
        	type: 'vbox',
            align: 'stretch',
            animate: true
        },
        
        defaults: {
            flex: 1,
            frame: true
        },
        
        items: [{
            title: 'Create New Reservation',
            xtype: 'reservation-reservationform',
            margins: '0 0 5 0'
        }, {
            title: 'History'
        }]
    }, {
        xtype: 'container',
        layout: {
            type: 'vbox',
            align: 'stretch',
            animate: true
        },
        defaults: {
            flex: 1,
            frame: true
        },
        items: [{
            title: 'Reservation Overview',
            xtype: 'reservation-chartpanel',
            margins: '0 0 5 0'
        }, {
            title: 'Hotel Overview',
        }]
    }]

});