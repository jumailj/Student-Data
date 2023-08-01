package com.studentdata.studentdata.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.studentdata.studentdata.dto.CreateStudentDTO;
import com.studentdata.studentdata.dto.StudentResponseDTO;
import com.studentdata.studentdata.dto.UpdateStudentDTO;
import com.studentdata.studentdata.dto.mapper.StudentMapper;
import com.studentdata.studentdata.repository.StudentRepository;
import com.studentdata.studentdata.service.StudentService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;
    private StudentRepository studentRepository;

    @GetMapping
    //Task 7: Create Get Request Handle
    public ModelAndView showStudents() {
        List<StudentResponseDTO> students = StudentMapper.toDTO(this.studentRepository.findAll());
        return new ModelAndView("students").addObject("students", students);
    }

    @GetMapping("/new")
    public ModelAndView showCreateForm() {
        return new ModelAndView("new-student").addObject("student", new CreateStudentDTO());
    }

    @PostMapping("/new")
    //Task 8: Create Post Mapping
    public String createStudent(@ModelAttribute("student") @Valid CreateStudentDTO studentDTO, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "new-student";
        }

        this.studentService.save(StudentMapper.toEntity(studentDTO));
        attributes.addFlashAttribute("message", "User registered successfully!");

        return "redirect:/students";
    }

    @GetMapping("/{id}")
    public ModelAndView showUpdateForm(@PathVariable String id) {
        StudentResponseDTO responseDTO = StudentMapper.toDTO(this.studentService.findById(id));
        return new ModelAndView("edit-student").addObject("student", responseDTO);
    }

    @PostMapping("/{id}")
    public String update(@PathVariable String id, @ModelAttribute("student") @Valid UpdateStudentDTO studentDTO, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            studentDTO.setId(id);
            return "edit-student";
        } 

        this.studentService.update(id, StudentMapper.toEntity(studentDTO));
        attributes.addFlashAttribute("message", "User updated successfully!");
        return "redirect:/students";
    }

    @GetMapping("/{id}/delete")
    //Task 9: Implement Delete Student
    public String delete(@PathVariable String id, RedirectAttributes attributes) {
        this.studentService.deleteById(id);
        attributes.addFlashAttribute("message", "User deleted successfully!");

        return "redirect:/students";
    }

}