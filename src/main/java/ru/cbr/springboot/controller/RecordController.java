package ru.cbr.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ru.cbr.springboot.entity.Record;
import ru.cbr.springboot.service.RecordService;

import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {
    private final RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @RequestMapping(path = "/searchAllByPzn", params = {"pzn"}, method = RequestMethod.GET)
    public List<Record> searchAllByPZN(@RequestParam String pzn) {
        return recordService.findAllByPzn(pzn);
    }

    @RequestMapping(path = "/search", params = {"rkc"}, method = RequestMethod.GET)
    public List<Record> searchAllByRkc(@RequestParam String rkc) {
        return recordService.searchAllByRkc(rkc);
    }

    @RequestMapping(path = "/searchAllByRgn", params = {"rgn"}, method = RequestMethod.GET)
    public List<Record> searchAllByRgn(@RequestParam String rgn) {
        return recordService.searchAllByRgn(rgn);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Record> searchAll() {
        return recordService.findAll();
    }



    //    @RequestMapping(method = RequestMethod.POST)
//    public void save(@PathVariable long recordId, @RequestBody Record record) {
//        recordService.save(record);
//    }
    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody Record record){
        recordService.save(record);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id){
        recordService.delete(id);
    }
}
