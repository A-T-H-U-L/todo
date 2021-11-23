import React ,{Component} from 'react';
import './Comp1.css';
import Service from './services/Service';

class Comp1 extends Component{
constructor(props){
super(props);
this.state={
items:[],
textContent :""

};

this.textChange=this.textChange.bind(this);
}


componentDidMount(){
Service.getall().then((response)=>{
  this.setState({items:response.data});
}

)

}


textChange = (e)=>{
 this.setState({textContent: e.target.value});
}

 
update =(e)=>{

  let task={
    task:e.target.value
  }

  Service.update(task).then(response=>{

    console.log(response);
  }
    
    )
    window.location.reload(false);
}



additem =(e)=>{
  let task={task:this.state.textContent

  }
//let currentText = this.state.textContent;
//let currentItems = this.state.items;
//currentItems.push(task);
//this.setState({items:currentItems});
console.log(task);

Service.save(task).then((res)=>{
    console.log(res)
  }
)
window.location.reload(false);
}
 



removeItem=(i)=>{
//  let currentItems = this.state.items;
//   currentItems.splice(i,1);
//   this.setState({items:currentItems});





  //let presenttask={
    
  // task:i.target.value
  //}
  Service.delete(i);
  console.log(i);
   window.location.reload(false);
}



render(){


return(
 

<div className="container text-center">

  <input type="text"  className="text" onChange={this.textChange} placeholder="   Enter your task" />
     <button className="forbutton" onClick ={this.additem}>Add</button>
  <br/> <br/> <center>
<table><tr><th className="col1"></th> <th className="col2"></th> </tr>

  {this.state.items.map((itm)=>{
    return(
 <div><tr><td  className="col1">{itm.status==="completed"?(<span>&#x2713;</span>):
 (<input type="checkbox"  value = {itm.task} Checked={this.state.task=itm.task} onClick={this.update} />)}&#x2800;&#x2800;&#x2800;
 <span style={{textDecoration:itm.status==="completed"? "line-through":""}}>
 {itm.task}</span></td><td ><button className="forbutton1" type="success" onClick={()=>{this.removeItem(itm)}}>delete</button></td></tr></div>
    )
    
  
  })}
 </table></center>


</div>
);

}


}

export default Comp1;