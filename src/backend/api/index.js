const app = require('express')();
const PORT = 8080;
app.listen(
    PORT,
    () => console.log('I\'m alive at http://localhost:' + PORT)
)
