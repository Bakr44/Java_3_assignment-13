package com.example.assignment13.Controller;

import com.example.assignment13.Model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/task")
public class TaskTrackerController {

    ArrayList<Task> tasks=new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Task> getTasks(){
        return tasks;
    }

    @PostMapping("/add")
    public String addTasks(@RequestBody Task task){
        tasks.add(task);
        return "added";
    }

    @PutMapping("/update/{index}")
    public String updateTask(@PathVariable int index,@RequestBody Task task){
    tasks.set(index,task);
    return "updated";
    }

    @DeleteMapping("/delete/{index}")
    public String deleteTask(@PathVariable int index){
        tasks.remove(index);
        return "deleted";
    }

    @PutMapping("/change/{index}")
public String changeStatus(@PathVariable int index){
        Task task = tasks.get(index);
        if(task.getStatus().equalsIgnoreCase("done")) {
            task.setStatus("not done");
        }else {
            task.setStatus("done");
        }
        return "changed";
    }

    @GetMapping("/search/{name}")
    public Task searchTask(@PathVariable String name){
        for (Task task:tasks) {
            if(task.getTitle().equalsIgnoreCase(name)){
                return task;
            }
        }
        return null;
    }


}
