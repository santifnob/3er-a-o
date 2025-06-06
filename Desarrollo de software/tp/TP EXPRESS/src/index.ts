import express from 'express'
import { Response } from 'express'
import { TipoCargaRouter } from './TipoCarga/tipocarga.routes.js'


const app = express()

app.listen(3000, () => {
  console.log('Server corriendo en el puerto 3000')
})

app.use(express.json())

app.use("/TipoCarga", TipoCargaRouter)

app.use((_, res) => {
  res.status(404).send({Message: 'No se encontro la pagina'})
})

app.use((_, res) => {
  res.status(405).send({Message: 'El metodo no es correcto'})
})

