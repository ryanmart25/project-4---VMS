function addRow() {
    const table = document.getElementById('editableTable').getElementsByTagName('tbody')[0];
    const newRow = table.insertRow();
    for (let i = 0; i < 2; i++) {
        const cell = newRow.insertCell(i);
        cell.setAttribute('contenteditable', 'true');
    }

}

