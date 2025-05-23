
//delete client button
function deleteClient(button) {
    const id = button.getAttribute('data-id');
    if (confirm('Czy na pewno chcesz usunąć tego klienta?')) {
        fetch('/clients/' + id, {
            method: 'DELETE'
        })
            .then(resp => {
                if (resp.ok) {
                    location.reload();
                } else {
                    alert('Błąd podczas usuwania klienta');
                }
            });
    }
}




function openEditModal(button) {

    document.getElementById('editClientId').value = button.getAttribute('data-id');
    document.getElementById('editFirstName').value = button.getAttribute('data-firstname');
    document.getElementById('editLastName').value = button.getAttribute('data-lastname');
    document.getElementById('editEmail').value = button.getAttribute('data-email');
    document.getElementById('editPhoneNumber').value = button.getAttribute('data-phonenumber');
    document.getElementById('editAddress').value = button.getAttribute('data-address');
    var modal = new bootstrap.Modal(document.getElementById('editClientModal'));
    modal.show();
}

document.getElementById('editClientForm').addEventListener('submit', function(e) {
    e.preventDefault();
    const id = document.getElementById('editClientId').value;
    const data = {
        firstName: document.getElementById('editFirstName').value,
        lastName: document.getElementById('editLastName').value,
        email: document.getElementById('editEmail').value,
        phoneNumber: document.getElementById('editPhoneNumber').value,
        address: document.getElementById('editAddress').value
    };
    fetch('/clients/' + id, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(resp => {
            if (resp.ok) {
                var modal = bootstrap.Modal.getInstance(document.getElementById('editClientModal'));
                modal.hide();
                location.reload();
            } else {
                alert('Błąd podczas zapisywania zmian');
            }
        });
});