import {useEffect, useState} from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import './App.css'

function App() {
  const [count, setCount] = useState(1)
    const [check,setCheck] =useState(0)

    useEffect(() => {
        if(check%3===0 && check!==0)
            setCount(count=> count*2);
    }, [check]);

    function handleClick(){
      setCheck(check=>check+1);
    }

  return (
    <>
        <h1>{count}</h1>
        <button onClick={handleClick}>INC</button>
    </>
  )
}

export default App
