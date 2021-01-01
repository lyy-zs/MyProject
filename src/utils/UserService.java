package utils;

import Client.PageBean;
import Client.user;

import java.util.List;

public class UserService {

    public PageBean<user> findUserByPage(String _currentPage,String _rows,String name){
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if(currentPage <= 0){
            currentPage =1;
        }
        //1.创建空的PageBean对象
        PageBean<user> pb = new PageBean<user>();

        //2.设置参数
        pb.setRows(rows);

        //3.查询总记录数
        int totalCount = UserUtils.findTotalCount(name);
        pb.setTotalCount(totalCount);

        //5.计算总页码
        int totalPage = (totalCount % rows) == 0 ? (totalCount/rows) : (totalCount/rows) +1;
        pb.setTotalPage(totalPage);

        if(currentPage>totalPage) {
            currentPage= totalPage;
        }
        pb.setCurrentPage(currentPage);
        System.out.println(currentPage  +"    asxascascasc");


        //4.查询List集合
        //需要计算开始的 索引
        int start = (currentPage - 1)*rows;
        List<user> list = UserUtils.findByPage(start,rows,name);
        pb.setList(list);
        if(currentPage > totalPage){
            currentPage = totalPage;
            pb.setCurrentPage(currentPage);
            System.out.println(pb.getCurrentPage());
        }

        return pb;
    }
}
