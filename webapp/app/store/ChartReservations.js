Ext.define('PHRS.store.ChartReservations', {
    extend: 'Ext.data.Store',

    model: 'PHRS.model.ChartReservation',

    storeId: 'ChartReservations',

    proxy: {
        type: 'memory'
    },

    autoLoad: true,

    data: [
        {year: 2004, comedy: 12303498, action: 34933223, drama: 23948222, thriller: 23498443, comic: 21000000, anime: 12395732, manga: 98324324},
        {year: 2005, comedy: 34000000, action: 23890000, drama: 18450000, thriller: 20060000, comic: 23484545, anime: 98324234, manga: 76234234},
        {year: 2006, comedy: 56703000, action: 38900000, drama: 12650000, thriller: 21000000, comic: 34904387, anime: 86234234, manga: 32498455},
        {year: 2007, comedy: 42100000, action: 50410000, drama: 25780000, thriller: 23040000, comic: 65932343, anime: 23435534, manga: 97234334},
        {year: 2008, comedy: 38910000, action: 56070000, drama: 24810000, thriller: 26940000, comic: 12221232, anime: 34598432, manga: 12345432}
    ]

});