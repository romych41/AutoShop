<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Romchik store</title>
    <link rel="stylesheet" href="sass/style.css">
    <link rel="stylesheet" href="css/style-ng.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
</head>
<body>
<div class="header" id="header">
    <div class="header-logo share">
        <h1>
            <span>R</span><span>o</span><span>m</span><span>c</span><span>h</span><span>i</span><span>k</span> <span>S</span><span>t</span><span>o</span><span>r</span><span>e</span>
        </h1>
    </div>

    <nav class="header-nav">
        <#if username??>
            <a class="header-username">Здравствуйте, ${username}</a>
            <form action="/logout" method="post">
                <input type="submit" value="Выйти" class="header-logout">
            </form>
        <#else>
            <a href="#" id="auth-button" class="header-nav__link auth">Войти</a>
            <a href="#" id="reg-button" class="header-nav__link registration">Регистрация</a>
        </#if>
    </nav>

    <a href="#" class="header-contacts">
        тел. (63) 555-55-55
    </a>
    <div class="header-basket">
        <i class="fas fa-shopping-basket"></i>
        <span class="header-basket-quantity">
                0
        </span>
    </div>

</div>
<a href="#catalogue" class="button button-catalogue"><i class="fas fa-table"></i></a>
<a href="#header" class="button button-top"><i class="fas fa-chevron-up"></i></a>
<div class="header-images">
    <div>
        <img class="rellax r1" data-rellax-speed="-1" src="img/image_part_001.png" alt="">
        <img class="rellax r1" data-rellax-speed="-3" src="img/image_part_002.png" alt="">
        <img class="rellax r1" data-rellax-speed="-1" src="img/image_part_003.png" alt="">
        <img class="rellax r1" data-rellax-speed="-3" src="img/image_part_004.png" alt="">
        <img class="rellax r1" data-rellax-speed="-1" src="img/image_part_005.png" alt="">
        <img class="rellax r1" data-rellax-speed="-3" src="img/image_part_006.png" alt="">
        <img class="rellax r1" data-rellax-speed="-1" src="img/image_part_007.png" alt="">
        <img class="rellax r1" data-rellax-speed="-3" src="img/image_part_008.png" alt="">
        <img class="rellax r1" data-rellax-speed="-1" src="img/image_part_009.png" alt="">
        <img class="rellax r1" data-rellax-speed="-3" src="img/image_part_010.png" alt="">
        <img class="rellax r1" data-rellax-speed="-1" src="img/image_part_011.png" alt="">
        <img class="rellax r1" data-rellax-speed="-3" src="img/image_part_012.png" alt="">
        <img class="rellax r1" data-rellax-speed="-1" src="img/image_part_013.png" alt="">
        <img class="rellax r1" data-rellax-speed="-3" src="img/image_part_014.png" alt="">
        <img class="rellax r1" data-rellax-speed="-1" src="img/image_part_015.png" alt="">
        <img class="rellax r1" data-rellax-speed="-3" src="img/image_part_016.png" alt="">
        <img class="rellax r1" data-rellax-speed="-1" src="img/image_part_017.png" alt="">
        <img class="rellax r1" data-rellax-speed="-3" src="img/image_part_018.png" alt="">
        <img class="rellax r1" data-rellax-speed="-1" src="img/image_part_019.png" alt="">
        <img class="rellax r1" data-rellax-speed="-3" src="img/image_part_020.png" alt="">
        <img class="rellax r1" data-rellax-speed="-1" src="img/image_part_021.png" alt="">
        <img class="rellax r1" data-rellax-speed="-3" src="img/image_part_022.png" alt="">
        <img class="rellax r1" data-rellax-speed="-1" src="img/image_part_023.png" alt="">
        <img class="rellax r1" data-rellax-speed="-3" src="img/image_part_024.png" alt="">
        <img class="rellax r1" data-rellax-speed="-1" src="img/image_part_025.png" alt="">
    </div>
</div>

<div class="catalogue" id="catalogue">
    <div class="category-picker">
        <h1 align="center">Выберите необходимые категории</h1>
        <form method="post" action="/filter">
            <div class="catalogue-filter">
        <div>
            <label>
                <input type="checkbox" name="engine">
                <span>Двигатель</span>
            </label>
        </div>
        <div>
            <label>
                <input type="checkbox" name="running gear">
                <span>Ходовая</span>
            </label>
        </div>
        <div>
            <label>
                <input type="checkbox" name="transmission">
                <span>Трансмиссия</span>
            </label>
        </div>
        <div>
            <label>
                <input type="checkbox" name="body">
                <span>Кузов</span>
            </label>
        </div>
        <div>
            <label>
                <input type="checkbox" name="electronic">
                <span>Электроника</span>
            </label>
        </div>
            </div>
        <div>
            <label>
                <input type="submit" value="Отфильтровать">
            </label>
        </div>
        </form>


    </div>
    <div class="catalogue-items">
        <#list details as detail>
        <div class="catalogue-items-item">
            <div class="item-image">
                <img src="${detail.pathToImage}">
            </div>
            <span> ${detail.name} </span>
            <span> #{detail.cost} грн. </span>
            <form method="post" action="/addOnBasket">
                <div class="item-quantity">
                    <a href="#" class="minus">-</a>
                    <input type="text" name="count" class="count" value="1" size="5" />
                    <a href="#" class="plus">+</a>
                    <input type="hidden" name="id" value="#{detail.id}"/>
                    <input type="submit" value="Добавить в корзину"/>
                </div>
            </form>
        </div>
        </#list>

    </div>
</div>

<div id="auth-modal">
    <span>Вход в личный кабинет</span>
    <form method="post" action="/">
        <input name="username" type="text" placeholder="Логин">
        <input name="password" type="password" placeholder="Пароль">
        <input type="submit" value="Войти">
    </form>
</div>
<div id="reg-modal">
    <span>Регистрация нового пользователя</span>
    <form method="post" action="/registration">
        <input placeholder="Логин" name="username" type="text">
        <input placeholder="Пароль" name="password1" type="password">
        <input placeholder="Повторите пароль" name="password2" type="password">
        <input type="submit" value="Зарегистрироваться">
    </form>

</div>

<div class="basket null-opacity top-removed">
    <#if basket??>
        <div class="basket-items">
        <#list basket as element>
            <div class="basket-item">
                <div class="basket-item-image">
                    <img src="${element.pathToImage}">
                </div>
                <span> ${element.name} </span>
                <span> #{element.cost} грн. </span>
                <form method="post">
                    <a href="/removeFromBasket?id=#{element.id}" class="basket-item-delete"><i class="fas fa-trash-alt"></i></a>
                </form>
            </div>
                </#list>
        </div>
        <#else>
    </#if>
    <form method="post" action="/checkout">
        <input type="submit" value="Оформить заказ">
    </form>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="js/rellax.min.js"></script>
<script>
    const rellax = new Rellax('.rellax');
</script>
<script src="js/PageScroll2id.min.js"></script>
<script src="js/main.js"></script>


</body>
</html>
