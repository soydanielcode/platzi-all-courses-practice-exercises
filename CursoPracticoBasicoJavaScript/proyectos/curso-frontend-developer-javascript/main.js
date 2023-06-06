const navEmail = document.querySelector(".navbar-email");
const navDesktopMenu = document.querySelector(".desktop-menu");
const mobileMenuIcon = document.querySelector(".menu");
const mobileMenu = document.querySelector(".mobile-menu");
const navbarShoppingCart = document.querySelector(".navbar-shopping-cart");
const productDetail = document.querySelector(".product-detail");
const cardsContainer = document.querySelector(".cards-container");
const productList = [];
productList.push(
  {
    name: "Laptop",
    price: "634",
    image:
      "https://images.pexels.com/photos/2528118/pexels-photo-2528118.jpeg?auto=compress&cs=tinysrgb&w=600",
  },
  {
    name: "Ipad",
    price: "534",
    image:
      "https://cdn.pixabay.com/photo/2016/12/11/22/41/lasagna-1900529_640.jpg",
  },
  {
    name: "SmartPhone",
    price: "634",
    image:
      "https://cdn.pixabay.com/photo/2013/10/03/23/19/bike-190483_1280.jpg",
  },
  {
    name: "Tv",
    price: "234",
    image:
      "https://cdn.pixabay.com/photo/2013/10/03/23/19/bike-190483_1280.jpg",
  },
  {
    name: "Refrigerator",
    price: "1634",
    image:
      "https://cdn.pixabay.com/photo/2013/10/03/23/19/bike-190483_1280.jpg",
  },
  {
    name: "Refrigerator",
    price: "1634",
    image:
      "https://cdn.pixabay.com/photo/2013/10/03/23/19/bike-190483_1280.jpg",
  },
  {
    name: "Refrigerator",
    price: "1634",
    image:
      "https://cdn.pixabay.com/photo/2013/10/03/23/19/bike-190483_1280.jpg",
  },
  {
    name: "Refrigerator",
    price: "1634",
    image:
      "https://cdn.pixabay.com/photo/2013/10/03/23/19/bike-190483_1280.jpg",
  },
  {
    name: "Refrigerator",
    price: "1634",
    image:
      "https://cdn.pixabay.com/photo/2013/10/03/23/19/bike-190483_1280.jpg",
  },
  {
    name: "Refrigerator",
    price: "1634",
    image:
      "https://cdn.pixabay.com/photo/2013/10/03/23/19/bike-190483_1280.jpg",
  },
  {
    name: "Refrigerator",
    price: "1634",
    image:
      "https://cdn.pixabay.com/photo/2013/10/03/23/19/bike-190483_1280.jpg",
  },
  {
    name: "Refrigerator",
    price: "1634",
    image:
      "https://cdn.pixabay.com/photo/2013/10/03/23/19/bike-190483_1280.jpg",
  },
  {
    name: "Refrigerator",
    price: "1634",
    image:
      "https://cdn.pixabay.com/photo/2013/10/03/23/19/bike-190483_1280.jpg",
  },
  {
    name: "Refrigerator",
    price: "1634",
    image:
      "https://cdn.pixabay.com/photo/2013/10/03/23/19/bike-190483_1280.jpg",
  },
  {
    name: "Refrigerator",
    price: "1634",
    image:
      "https://cdn.pixabay.com/photo/2013/10/03/23/19/bike-190483_1280.jpg",
  },
  {
    name: "Refrigerator",
    price: "1634",
    image:
      "https://cdn.pixabay.com/photo/2013/10/03/23/19/bike-190483_1280.jpg",
  },
  {
    name: "Refrigerator",
    price: "1634",
    image:
      "https://cdn.pixabay.com/photo/2013/10/03/23/19/bike-190483_1280.jpg",
  }
);

navEmail.addEventListener("click", toggleDesktopMenu);
mobileMenuIcon.addEventListener("click", toggleMobileMenu);
navbarShoppingCart.addEventListener("click", toggleShoppingCart);

function toggleDesktopMenu() {
  /*const productDetailOpen = !productDetail.classList.contains('inactive');
    if(productDetailOpen)productDetail.classList.toggle('inactive');*/
  productDetail.classList.add("inactive");
  navDesktopMenu.classList.toggle("inactive");
}

function toggleMobileMenu() {
  /*const productDetailOpen = !productDetail.classList.contains('inactive');
     if(productDetailOpen)productDetail.classList.toggle('inactive');*/
  productDetail.classList.add("inactive");
  mobileMenu.classList.toggle("inactive");
}

function toggleShoppingCart() {
  /*const navDesktopMenuOpen = !navDesktopMenu.classList.contains('inactive');
    const mobileMenuOpen = !mobileMenu.classList.contains('inactive');
    if(mobileMenuOpen)mobileMenu.classList.toggle('inactive');
    if(navDesktopMenuOpen)navDesktopMenu.classList.toggle('inactive');*/
  navDesktopMenu.classList.add("inactive");
  mobileMenu.classList.add("inactive");
  productDetail.classList.toggle("inactive");
}

function renderProducts(array) {
      /*<div class="cards-container">
          <div class="product-card">
            <img src="https://images.pexels.com/photos/276517/pexels-photo-276517.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" alt="">
            <div class="product-info">
              <div>
                <p>$120,00</p>
                <p>Bike</p>
              </div>
              <figure>
                <img src="./icons/bt_add_to_cart.svg" alt="">
              </figure>
            </div>
          </div>
        </div>*/
  for (const product of array) {
    const productCard = document.createElement('div');
    const image = document.createElement('img');
    const productInfo = document.createElement('div');
    const productInfoDiv = document.createElement('div');
    const price = document.createElement('p');
    const name = document.createElement('p');
    const figure = document.createElement('figure');
    const imgFigure = document.createElement('img');

    image.setAttribute('src', product.image);
    productCard.classList.add('product-card');
    productInfo.classList.add('product-info');
    price.innerText = `$${product.price}`;
    name.innerText = product.name;
    imgFigure.setAttribute('src', './icons/bt_add_to_cart.svg');

    figure.appendChild(imgFigure);
    productInfoDiv.append(price, name);
    // productInfoDiv.appendChild(name);
    productInfo.append(productInfoDiv, figure);
    // productInfo.appendChild(figure);
    productCard.append(image, productInfo);
    // productCard.appendChild(productInfo);
    cardsContainer.appendChild(productCard);
  }
}

renderProducts(productList);