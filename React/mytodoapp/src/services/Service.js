

import axios from "axios";

class Service{

save(task){

return axios.post("http://localhost:8080/save",task);

}

getall(){
    return axios.get("http://localhost:8080/viewall");
  
}
update(task){
    return axios.post("http://localhost:8080/updatebyname",task);

}
delete(task){
    return axios.post("http://localhost:8080/deletetask",task);
}
}
export default new Service();