import logo from './logo.svg';
import './App.css';
import react from 'react';
import Header from './Home';
import Comp1  from './Comp1';
//import Button from './Comp1';
 
function App() {
  //var name="ATHUL"
//var age =18;

  return (
    
 <react.Fragment>

   <Header/>
   <br/><br/><br/>
   <center><div className="container">
     <div className="row">
     <div className="col-sm-4 offset-4 divup">
       <div height="40px" width="100px" className="divdown">
       <br/><br/>     
      
<Comp1/>
<br/><br/><br/>
</div>
</div>
</div>
</div>

</center>
  
 </react.Fragment>

  );
}

export default App;
