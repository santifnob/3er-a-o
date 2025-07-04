//Mi prueba de REACT
//import { StrictMode } from 'react'
import React from 'react'
//import { createRoot } from 'react-dom/client'
import ReactDom from 'react-dom/client'
import { App } from './App.jsx'
import './index.css'
import './App.css'

const root = ReactDom.createRoot(document.getElementById('root'))

root.render(
  <App/>
)

