$('#toDatePicker')
    .datepicker({
        format: 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight: true,
        startDate:new Date()
        
    })
    .on('changeDate', function(e) {
        var startDate = new Date(e.date);
        startDate.setDate(startDate.getDate() + 1);
        $('#fromDatePicker').datepicker('setStartDate', startDate);
    });

