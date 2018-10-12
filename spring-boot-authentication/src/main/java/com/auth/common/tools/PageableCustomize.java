package com.auth.common.tools;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * The type Pageable customize.
 *
 * @ClassName PageableCustomize
 * @Description TODO
 * @Author Calvin
 * @Date 10 /12/18
 * @Version 1.0
 */
public class PageableCustomize {

    /**
     * Gets pageable.
     *
     * @param limit     the limit
     * @param offset    the offset
     * @param sortOrder the sort order
     * @param sortBy    the sort by
     * @return the pageable
     */
    public static Pageable getPageable(Integer limit,
                                       Integer offset,
                                       String sortOrder,
                                       String sortBy) {
        int page = offset / limit;
        int size = limit;
        Sort sort;
        if ("asc".equals(sortOrder)){
            sort = new Sort(Sort.Direction.ASC, sortBy);
        }else {
            sort = new Sort(Sort.Direction.DESC, sortBy);
        }
        return PageRequest.of(page, size, sort);
    }
}
