$(document).ready(function() {
    $('.button-catalogue, .button-top').mPageScroll2id({});

    $('.minus').click(function () {
        var $input = $(this).parent().find('input[type="text"]');
        var count = parseInt($input.val()) - 1;
        count = count < 1 ? 1 : count;
        $input.val(count);
        $input.change();
        return false;
    });

    $('.plus').click(function () {
        var $input = $(this).parent().find('input[type="text"]');
        $input.val(parseInt($input.val()) + 1);
        $input.change();
        return false;
    });

    $('.add-to-basket').click(function () {
        var $input = $(this).parent().find('input[type="text"]');
        $input.val(1);
        $input.change();
        return false;
    });

    $('.header-basket > i').click(function() {
        $('.basket').toggleClass('null-opacity top-removed');
    });

    let quantity = $('.basket-items').children('div').length;
    $('.header-basket > span').html(`${quantity}`);
});

function modal(selectorButton, selectorContent) {
    let body = $('body');
    let content = $(selectorContent);
    let button = $(selectorButton);
    let submitButton = $(selectorContent + ' > input[type="submit"]');
    let form = $(selectorContent + ' > form');

    body.prepend(
        '<div class="modal" data-modal="'
        + selectorButton
        + '">'
        + '<div class="modal__content">'
        + '<a href="#" class="modal__close">&times</a>'
        + '</div>'
        + '</div>'
    );

    let modal = $(
        '.modal[data-modal="'
        + selectorButton
        + '"]'
    );

    let close = modal.find('.modal__close');

    modal
        .find('.modal__content')
        .append(content);

    button.on('click', function(e) {
        e.preventDefault();
        modal.addClass('modal_active');

    });

    close.on('click', function(e) {
        e.preventDefault();
        modal.removeClass('modal_active');
    });

    submitButton.on('click', function(e) {
        e.preventDefault();
        form.trigger('reset');
        modal.removeClass('modal_active');
    });
}


modal('#auth-button', '#auth-modal');
modal('#reg-button', '#reg-modal');