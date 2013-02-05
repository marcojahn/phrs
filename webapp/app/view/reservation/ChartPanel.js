Ext.define('PHRS.view.reservation.ChartPanel', {
    extend: 'Ext.panel.Panel',

    requires: [
        'PHRS.store.ChartReservations'
    ],

    alias: 'widget.reservation-chartpanel',

    title: 'Reservations',

    store: 'ChartReservations',

    initComponent: function () {

        this.chartStore = Ext.create('PHRS.store.ChartReservations');

        // TODO createChart and add to panel must be done after chart data is loaded
        this.items = [ this.createChart() ];

        this.callParent(arguments);
    },

    createChart: function () {

        return Ext.create('Ext.chart.Chart', {
            animate: true,
            shadow: true,
            width: 600,
            height: 250,
            store: this.chartStore,
            legend: {
                position: 'right'
            },

            axes: this.getAxesConfig(),

            series: this.getSeriesConfig()

        });

    },

    getAxesConfig: function () {
        return [
            {
                type: 'Numeric',
                position: 'bottom',
                fields: ['comedy', 'action', 'drama', 'thriller', 'comic', 'anime', 'manga'],
                title: false,
                grid: true,
                label: {
                    renderer: function (v) {
                        return String(v).replace(/(.)00000$/, '.$1M');
                    }
                }
            },
            {
                type: 'Category',
                position: 'left',
                fields: ['year'],
                title: false
            }
        ];
    },

    getSeriesConfig: function () {
        return [{
            type: 'bar',
            axis: 'bottom',
            gutter: 80,
            xField: 'year',
            yField: ['comedy', 'action', 'drama', 'thriller', 'comic', 'anime', 'manga'],
            stacked: true,
            tips: {
                trackMouse: true,
                width: 65,
                height: 28,
                renderer: function(storeItem, item) {
                    this.setTitle(String(item.value[1] / 1000000) + 'M');
                }
            }
        }];
    }

});