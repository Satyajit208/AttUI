$('#toDatePicker')
    .datepicker({
        format: 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight: true,
        startDate:new Date(),
        daysOfWeekDisabled: [0,6]
    })
    .on('changeDate', function(e) {
        var startDate = new Date(e.date);
        startDate.setDate(startDate.getDate() + 1);
        $('#fromDatePicker').datepicker('setStartDate', startDate);
    });

$('#fromDatePicker')
    .datepicker({
        format: 'yyyy-mm-dd',
        autoclose: true,
        todayHighlight: true
        
    })
    .on('changeDate', function(e) {
     
    });