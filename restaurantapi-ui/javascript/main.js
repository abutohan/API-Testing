document.addEventListener("DOMContentLoaded", fetchAppetizers("main-courses"));

function fetchAppetizers(menu) {
  fetch(`http://18.139.187.143:8080/restaurant/api/v1/${menu}`)
    .then((response) => response.json())
    .then((data) => {
      displayData(data, menu);
    })
    .catch((error) => console.error("Error fetching data:", error));
}

function displayData(data, menu) {
  const dataContainer = document.getElementById("data-container");
  data.forEach((item) => {
    const itemDiv = document.createElement("div");
    itemDiv.classList.add("data-item");
    itemDiv.innerHTML = `
      <h3>${item.name}</h3>
      <img src="/img/${menu}/${item.image}" alt="${item.name}">
      <p>${item.description}</p>
    `;
    dataContainer.appendChild(itemDiv);
  });
}
