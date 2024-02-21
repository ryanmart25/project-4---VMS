const express = require('express');
const app = express()


const PORT = 8383;
app.use(express.static('html'))
app.listen(
    PORT,
    () => console.log('I\'m alive at http://localhost:' + PORT)
)


//patch

//delete
