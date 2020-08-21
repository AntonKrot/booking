let userId;
let addRoom = document.querySelector('.addRoom');
let user = document.querySelector('.user-name');
let popup = document.querySelector('.popup');
let btnPopupClose = document.querySelector('.closePopup');
let btnSuccess = document.querySelector('.successPopup');
const selectItem = document.querySelector(".select");
const note = document.querySelector(".note");

const closePopup = () => {
    selectItem.value = "1";
    note.value = "";
    popup.style.display = "none"
}

addRoom.addEventListener('click', () => {
    add();
});

btnPopupClose.addEventListener('click', () => {
    closePopup();
});

btnSuccess.addEventListener('click', () => {
    saveRoom();
});

const saveRoom = () => {
    const data = {
        description: note.value,
        roomTypeId: selectItem.value
    }
    fetch('/room/create', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(data)
    })
        .then(response => {
            return response.json();
        })
        .then(data => {
            closePopup();
            alert('Добавлено успешно')
        });
};

const add = () => {
    const select = data => {
        let option = "";
        data.map(item => {
            option += `<option value="${item.id}">${item.name}</option>`
        });
        selectItem.innerHTML = option;
        popup.style.display = "block"
    }

    fetch('/room/type/list', {
        method: 'GET',
        headers: {'Content-Type': 'application/json'}
    })
        .then(response => {
            return response.json();
        })
        .then(data => {
            select(data);
        });
};

const list = userId => {
    const data = {
        userId,
        statusId: 1
    }
    fetch('/booking/list', {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {'Content-Type': 'application/json'}
    })
        .then(response => {
            return response.json();
        })
        .then(data => {
            table(data)
        });
};

const table = bookingList => {
    const table = document.querySelector('.table');
    let tbody = table.querySelector('tbody');
    let tableTr = "";

    bookingList.forEach(item => {
        tableTr += `<tr id="item.id"">
            <td>${item.startDateTime}</td>
            <td>${item.endDateTime}</td>
            <td>${item.manipulationName}</td>
            <td>${item.manipulationDescription}</td>
            <td>${item.room.roomType.name}</td>
            <td><button class="btn btn-danger" name="${item.id}" onclick="deleteItem(event)">Удалить</button></td>
        </tr>`
    });
    tbody.innerHTML = tableTr;
}

const deleteItem = event => {
    const item = event.target;
    const id = item.getAttribute("name");

    fetch(`/booking/cancel/${id}`)
        .then(data => {
            if (data.status === 200) {
                list(userId)
                alert("Удалено успешно")
            } else {
                alert("Ошибка удаления")
            }
        });
};

fetch('/user/current')
    .then(response => {
        return response.json();
    })
    .then(data => {
        user.innerHTML = `<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-person-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
              <path fill-rule="evenodd" d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
            </svg>${data.fullName}`;
        userId = data.id;
        list(data.id);
    });
