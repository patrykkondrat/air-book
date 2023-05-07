
$(document).ready(function() {
    $('.card-header').click(function() {
        var $collapse = $(this).next('.collapse');
        if ($collapse.hasClass('show')) {
            $('.collapse.show').collapse('hide');
        } else {
            $('.collapse.show').collapse('hide');
            $collapse.collapse('show');
        }
    });
});