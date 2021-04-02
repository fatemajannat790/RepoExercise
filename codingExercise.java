package ThirdPkg;

    /**
The class is designed to take in an array of values and an integer indicating how many items will be
allowed per each page. The types of values contained within the collection/array are not relevant.
The following are some examples of how this class is used:
helper = PaginationHelper.new(['a','b','c','d','e','f'], 4)
helper.pageCount() # should == 2
helper.itemCount() # should == 6
helper.pageItemCount(0) # should == 4
helper.pageItemCount(1) # last page - should == 2
helper.pageItemCount(2) # should == -1 since the page is invalid
# page_index takes an item index and returns the page that it belongs on
helper.pageIndex(5) # should == 1 (zero based index)
helper.pageIndex(2) # should == 0
helper.pageIndex(20) # should == -1
helper.pageIndex(-10) # should == -1 because negative indexes are invalid
*/
    class PaginationHelper {
        int valueCount;                 // Num of values
        int maxOnPage;                  // Max items on page
        int pages;                      // Total num of pages

        public PaginationHelper(Object[] values, int maxx) {  // Constructor
            valueCount = values.length;
            maxOnPage = maxx;
            int i = valueCount;
            pages = 0;
            while (i > 0) {
                i -= maxx;
                pages++;
            }
        }

        public int pageCount() {
            return pages;
        }

        public int itemCount() {
            return valueCount;
        }

        public int pageItemCount(int page) {
            if (page < pages) return maxOnPage;
            return -1;
        }

        public int pageIndex(int itemidx) {
            if ((itemidx < 0) || (itemidx > valueCount)) return -1;
            return itemidx / maxOnPage;
        }

        // Main program to test it:
    }
    class Main
    {
        public static void main(String[] args) {
            PaginationHelper p = new PaginationHelper (new Object[] { 'a', 'b', 'c'}, 2);
            Character [] arr = {'a','b','c','d','e','f'};
            PaginationHelper h = new PaginationHelper (arr, 4);
            System.out.println (h.pageCount ());
            System.out.println (h.itemCount ());
            System.out.println (h.pageItemCount (0));
            System.out.println (h.pageItemCount (2));
            System.out.println (h.pageIndex(5));
            System.out.println (h.pageIndex(2));
            System.out.println (h.pageIndex(20));
            System.out.println (h.pageIndex(-10));
        }
    }
