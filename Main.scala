import collection.mutable.PriorityQueue

class MedianOfIntegerStream {
  val minHeap = new PriorityQueue[Int]();
  val maxHeap = new PriorityQueue[Int]()(Ordering[Int].reverse);

  def add(num: Int): Unit = {
    if (minHeap.size == maxHeap.size) {
      maxHeap.enqueue(num);
      minHeap.enqueue(maxHeap.dequeue());
    } else {
      minHeap.enqueue(num);
      maxHeap.enqueue(minHeap.dequeue());
    }
  }

  def getMedian(): Int = {
    if (minHeap.size > maxHeap.size) {
      return minHeap.head;
    } else {
      return (minHeap.head + maxHeap.head) / 2;
    }
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    val median = new MedianOfIntegerStream();

    val stream = Array(10,9,8,7,6,5,4,3,2,1);

    for (x <- stream) {
      median.add(x);
    }

    println(s"Median ${median.getMedian}")
  }
}
